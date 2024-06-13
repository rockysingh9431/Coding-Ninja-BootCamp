import { fetchStocksData } from "./fetchApi.js";

let chart; // Move chart reference outside of the function

// Main function to draw the stock chart
export const drawChartFunction = (name) => {
  console.log("hiii");
  let stockData;
  let stockDataArray = [];

  // Function to fetch stock data and initialize chart
  const getStocks = async () => {
    stockData = await fetchStocksData();
    createStockDataArray(stockData[name]);
    calculateMaxY("1mo");
    calculateMinY("1mo");
    drawChart("1mo"); // Initialize with 1 month data
    canvasElement.canvas.addEventListener("mousemove", drawGraph);
  };

  // Function to create an array of stock data for each period
  const createStockDataArray = (stockData) => {
    for (const period in stockData) {
      if (stockData[period] && stockData[period].timeStamp) {
        const timeStamp = stockData[period].timeStamp.map((time) =>
          new Date(time * 1000).toLocaleDateString()
        );
        stockDataArray[period] = timeStamp.map((time, ind) => ({
          date: time,
          price: stockData[period].value[ind],
        }));
      }
    }
  };

  // Function to calculate the maximum Y value for a given period
  const calculateMaxY = (period) => {
    let max = 0;
    const data = stockDataArray[period];
    for (const point of data) {
      if (point.price > max) {
        max = point.price;
      }
    }
    return max + 10;
  };

  // Function to calculate the minimum Y value for a given period
  const calculateMinY = (period) => {
    let min = Infinity;
    const data = stockDataArray[period];
    for (const point of data) {
      if (point.price < min) {
        min = point.price;
      }
    }
    return min - 10;
  };

  // Function to get the peak (highest) and lowest values for a given period
  const getPeakAndLowest = (period) => {
    const data = stockDataArray[period];
    let max = Math.max(...data.map((point) => point.price));
    let min = Math.min(...data.map((point) => point.price));
    return { max, min };
  };

  const canvasElement = document.getElementById("stockChart").getContext("2d");

  // Clear the canvas and destroy the existing chart if it exists
  if (chart) {
    chart.destroy();
  }

  // Initialize the Chart.js chart
  chart = new Chart(canvasElement, {
    type: "line",
    data: {
      labels: [],
      datasets: [
        {
          label: "", // Remove the label
          data: [],
          borderColor: "rgba(255, 99, 132, 1)",
          fill: false,
        },
      ],
    },
    options: {
      plugins: {
        legend: {
          display: false, // Disable the legend
        },
        title: {
          display: true,
          text: "1 month", // Default title
          font: {
            size: 16,
          },
        },
        tooltip: {
          mode: "line",
          lineColor: "rgba(255, 99, 132, 1)", // Color of the line tooltip
          lineWidth: 2, // Width of the line tooltip
          borderWidth: 1, // Border width of the line tooltip
          intersect: false, // This is important to make the line tooltip visible
        },
      },
      scales: {
        y: {
          beginAtZero: true,
          ticks: {
            callback: function (value) {
              if (value % 10 === 0) {
                return value;
              }
            },
          },
        },
      },
    },
  });

  // Function to draw the chart for a given period
  const drawChart = (period) => {
    const data = stockDataArray[period];
    chart.data.labels = data.map((point) => point.date);
    chart.data.datasets[0].data = data.map((point) => point.price);
    chart.options.scales.y.max = calculateMaxY(period);
    chart.options.scales.y.min = calculateMinY(period);

    const { max, min } = getPeakAndLowest(period);

    // Update the title based on the selected period and peak/lowest values
    let periodText;
    switch (period) {
      case "1mo":
        periodText = "1 month";
        break;
      case "3mo":
        periodText = "3 months";
        break;
      case "1y":
        periodText = "1 year";
        break;
      case "5y":
        periodText = "5 years";
        break;
      default:
        periodText = "Custom Period";
        break;
    }
    chart.options.plugins.title.text = `${periodText} 👉  ⬆️High:  $${max.toFixed(
      2
    )}    ⬇️Low:  $${min.toFixed(2)}`;

    chart.update();
  };

  // Function to handle mouse move events on the canvas and update the chart
  const drawGraph = (event) => {
    const mouseX = event.offsetX;
    const mouseY = event.offsetY;
    const period =
      document.querySelector(".buttons button.active")?.value || "1mo";
    const data = stockDataArray[period];
    const index = Math.floor(
      (mouseX / canvasElement.canvas.width) * data?.length
    );
    const point = data[index];

    if (point) {
      drawChart(period);
      const x = (index / data.length) * canvasElement.canvas.width;
      const y = canvasElement.canvas.height - point.price;

      // Update the tooltip with the new position and data
      chart.tooltip.update({
        mode: "line",
        x: x,
        y: y,
        title: point.date,
        body: [
          {
            label: period,
            value: point.price,
            fontColor: "rgba(255, 99, 132, 1)",
          },
        ],
      });
    }
  };

  // Add event listeners to the time period buttons
  document.querySelectorAll(".timer-btn").forEach((button) => {
    button.addEventListener("click", (event) => {
      document
        .querySelectorAll(".timer-btn")
        .forEach((btn) => btn.classList.remove("active"));
      event.target.classList.add("active");
      drawChart(event.target.value);
    });
  });

  // Fetch and display the stock data
  getStocks();
};
