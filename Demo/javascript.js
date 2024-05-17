const main = () => {
  let yearData = {};
  const createPerYearData = (year, total) => (yearData[year] = total);
  const printReport = () => console.log("Print Report");

  const calculateTotalTillDate = (perYearBalance) => {
    let total = 0;
    for (let i = 0; i < perYearBalance.length; i++) {
      total += perYearBalance[i];
    }
    return total;
  };

  const adjustTotalOfYear = (year, adjustmentFactor) =>
    (yearData[year] *= adjustmentFactor);
  //Do not modify the code after this
  return {
    createPerYearData,
    printReport,
    calculateTotalTillDate,
    adjustTotalOfYear,
  };
};
const {
  createPerYearData,
  printReport,
  calculateTotalTillDate,
  adjustTotalOfYear,
} = main();
console.log(createPerYearData);
printReport();
console.log(calculateTotalTillDate([50000, 2000, 7000]));
adjustTotalOfYear(2020, 3000);
