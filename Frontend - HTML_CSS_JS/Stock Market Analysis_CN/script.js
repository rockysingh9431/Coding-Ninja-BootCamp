import {
  fetchStocks,
  fetchStocksData,
  fetchStocksSummary,
} from "./fetchApi.js";
import { drawChartFunction } from "./chart.js";

const stockListElement = document.getElementById("stocks-list");

// Main function to fetch stock data and render the components
const getStocks = async () => {
  const stocksList = await fetchStocks();
  const stocksSummary = await fetchStocksSummary();
  const stocksData = await fetchStocksData();
  drawChartFunction("AAPL");
  console.log(stocksData);
  renderAsideComponent(stocksList, stocksSummary);
};

// Function to render the stock list in the aside component
const renderAsideComponent = (stocksList, stocksSummary) => {
  let delay = 0;

  // Display details of the first stock by default
  const firstStockName = Object.keys(stocksList)[0];
  const firstStock = Object.values(stocksList)[0];
  showStockDetails(
    firstStockName,
    firstStock.profit,
    firstStock.bookValue,
    stocksSummary[firstStockName].summary
  );

  // Loop through each stock and create its HTML element
  Object.entries(stocksList).forEach(([key, value]) => {
    if (key !== "_id") {
      setTimeout(() => {
        const stockElement = document.createElement("div");
        stockElement.className = "stock-item";
        stockElement.innerHTML = `
          <button id='stock-btn' class="name-btn">${key}</button>
          <div class="stock-value">$${value.bookValue}</div>
          ${
            value.profit > 0
              ? `<div class="stock-profit">${value.profit.toFixed(2)}%</div>`
              : `<div class="stock-loss">${value.profit.toFixed(2)}%</div>`
          }
        `;

        // Append the created stock element to the stock list
        stockListElement.appendChild(stockElement);

        // Add an event listener to handle click events on the stock name button
        stockElement
          .querySelector(".name-btn")
          .addEventListener("click", () => {
            showStockDetails(
              key,
              value.profit,
              value.bookValue,
              stocksSummary[key].summary
            );
            drawChartFunction(key);
          });
      }, delay);
      delay += 1000;
    }
  });
};

// Function to display stock details
const showStockDetails = (
  stockName,
  stockProfit,
  stockBookValue,
  stockSummary
) => {
  const stockDetailsElement = document.getElementById("stock-details");
  stockDetailsElement.innerHTML = `
    <div class="stock-details">
      <div class="stock-name">${stockName}</div>
      ${
        stockProfit > 0
          ? `<div class="stock-profit">${stockProfit.toFixed(2)}%</div>`
          : `<div class="stock-loss">${stockProfit.toFixed(2)}%</div>`
      }
      <div class="stock-book-value">$${stockBookValue}</div>
    </div>
    <div class="summary">
      <div class="stock-summary">${stockSummary}</div>
    </div>
  `;
};

// Fetch and display the stock data when the script loads
getStocks();
