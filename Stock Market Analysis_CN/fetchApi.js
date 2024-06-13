export const fetchStocks = async () => {
  const response = await fetch(
    "https://stocks3.onrender.com/api/stocks/getstockstatsdata"
  );
  const data = await response.json();
  return data.stocksStatsData[0];
};
export const fetchStocksSummary = async () => {
  const response = await fetch(
    "https://stocks3.onrender.com/api/stocks/getstocksprofiledata"
  );
  const data = await response.json();
  return data.stocksProfileData[0];
};
export const fetchStocksData = async () => {
  const response = await fetch(
    "https://stocks3.onrender.com/api/stocks/getstocksdata"
  );
  const data = await response.json();
  return data.stocksData[0];
};
