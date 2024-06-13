const quesJSON = [
  {
    correctAnswer: "Three ",
    options: ["Two", "Three ", "Four", "Five"],
    question: "How many pieces of bun are in a Mcdonald's Big Mac?",
  },
  {
    correctAnswer: "L. Frank Baum",
    options: [
      "Suzanne Collins",
      "James Fenimore Cooper",
      "L. Frank Baum",
      "Donna Leon",
    ],
    question: "Which author wrote 'The Wonderful Wizard of Oz'?",
  },
  {
    correctAnswer: "Atlanta United",
    options: [
      "Atlanta United",
      "Atlanta Impact",
      "Atlanta Bulls",
      "Atlanta Stars",
    ],
    question: "Which of these is a soccer team based in Atlanta?",
  },
  {
    correctAnswer: "A Nanny",
    options: ["A Sow", "A Lioness", "A Hen", "A Nanny"],
    question: "A female goat is known as what?",
  },
  {
    correctAnswer: "P. L. Travers",
    options: [
      "J. R. R. Tolkien",
      "P. L. Travers",
      "Lewis Carroll",
      "Enid Blyton",
    ],
    question: "Which author wrote 'Mary Poppins'?",
  },
];

let score = 0;
const totalScore = quesJSON.length;
let currentQuestion = 0;
const quesEle = document.getElementById("question");
const optionsEle = document.getElementById("options");
const scoreEle = document.getElementById("score");
const nextEle = document.getElementById("next");

nextEle.addEventListener("click", () => {
  scoreEle.textContent = `score: ${score}`;
  nextQuestion();
});
function showQuestion() {
  const { question, options, correctAnswer } = quesJSON[currentQuestion];
  quesEle.textContent = question;
  const shuffledOption = shuffledOptions(options);
  shuffledOption.forEach((answer) => {
    const btnOption = document.createElement("button");
    btnOption.textContent = answer;
    optionsEle.appendChild(btnOption);

    btnOption.addEventListener("click", () => {
      if (answer === correctAnswer) {
        score += 1;
        scoreEle.textContent = `score: ${score}`;
      } else {
        score -= 0.25;
        scoreEle.textContent = `score: ${score}`;
      }
      nextQuestion();
    });
  });
}

function nextQuestion() {
  currentQuestion++;
  if (currentQuestion < quesJSON.length) {
    optionsEle.textContent = "";
    showQuestion();
  } else {
    quesEle.textContent = "Quiz Completed";
    optionsEle.textContent = "";
    nextEle.remove();
  }
}

function shuffledOptions(options) {
  for (let i = options.length - 1; i >= 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [options[i], options[j]] = [options[j], options[i]];
  }
  return options;
}
showQuestion();
