const sentences = `The quick brown fox jumps over the lazy dog.
  Sphinx of black quartz, judge my vow.
  Pack my box with five dozen liquor jugs.
  How vexingly quick daft zebras jump!`;

const sentenceArray = sentences.split(/\s+/); // Split by any whitespace
let timer;
let startTime, endTime;

const sentenceElement = document.getElementById("sentence");
const inputElement = document.getElementById("input");
const startButton = document.getElementById("start-btn");
const timerElement = document.getElementById("timer");
const speedElement = document.getElementById("speed");
const accuracyElement = document.getElementById("accuracy");
const resultElement = document.getElementById("result");
const retryButton = document.getElementById("retry-btn");

function startTest() {
  sentenceElement.innerHTML = sentences;
  inputElement.disabled = false;
  startButton.disabled = true;
  inputElement.focus();
  startTime = new Date();
  timer = setInterval(updateTimer, 1000);
  setTimeout(endTest, 10000);
}

function updateTimer() {
  const currentTIme = new Date();
  const elapsedTime = Math.floor((currentTIme - startTime) / 1000);
  const remainingTime = 30 - elapsedTime;
  const minutes = Math.floor(remainingTime / 60);
  const seconds = remainingTime % 60;
  timerElement.textContent = `${minutes.toString().padStart(2, "0")}:${seconds
    .toString()
    .padStart(2, "0")}`;
}
startButton.addEventListener("click", startTest);

function endTest() {
  clearInterval(timer);
  endTime = new Date();
  const elapsedTime = Math.floor((endTime - startTime) / 1000);
  const typedSentence = inputElement.value.trim();
  const typedWords = typedSentence.split(" ");
  resultElement.style.display = "block";
  calculateWpmAndAccuracy(typedWords);
}

function calculateWpmAndAccuracy(typedWords) {
  let correctWords = 0;
  typedWords.forEach((word, index) => {
    if (word === sentenceArray[index]) {
      correctWords++;
    }
  });
  const accuracyPercentage = (
    (correctWords / sentenceArray.length) *
    100
  ).toFixed(2);
  const speed = correctWords * 2; // 30 seconds test, so multiply by 2 for WPM

  speedElement.innerHTML = `${speed}`;
  accuracyElement.innerHTML = `${accuracyPercentage}`;
}
retryButton.addEventListener("click", () => {
  resultElement.style.display = "none";
  startButton.disabled = false;
  inputElement.value = "";
});
