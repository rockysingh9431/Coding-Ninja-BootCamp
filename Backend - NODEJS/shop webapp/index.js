import express from "express"; // Importing Express.js
import ProductsController from "./src/controllers/product.controller.js"; // Importing the ProductsController
import UserController from "./src/controllers/user.controller.js"; // Importing the UserController
import ejsLayouts from "express-ejs-layouts"; // Importing the Express EJS layouts middleware
import path from "path"; // Importing the path module to handle file paths
import validationMiddleware from "./src/middlewares/validation.middleware.js"; // Importing custom validation middleware
import { uploadFile } from "./src/middlewares/file-upload.middleware.js"; // Importing file upload middleware
import session from "express-session"; // Importing session management middleware
import { auth } from "./src/middlewares/auth.middleware.js"; // Importing authentication middleware
import cookieParser from "cookie-parser"; // Importing middleware to parse cookies
import { setLastVisit } from "./src/middlewares/lastVisit.middleware.js"; // Importing middleware to track the last visit time

const app = express(); // Initializing an Express application

// Serving static files from the 'public' directory
app.use(express.static("public"));

// Using cookie parser middleware
app.use(cookieParser());

// Configuring and using session management middleware
app.use(
  session({
    secret: "SecretKey", // Secret key for signing the session ID cookie
    resave: false, // Prevents session from being saved back to the session store if it wasn't modified
    saveUninitialized: true, // Forces a session that is "uninitialized" to be saved to the store
    cookie: { secure: false }, // The cookie is not secure (should be true in production for HTTPS)
  })
);

// Initializing controller instances
const productsController = new ProductsController();
const usersController = new UserController();

// Using EJS layouts middleware
app.use(ejsLayouts);

// Middleware for parsing JSON and URL-encoded form data
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

// Setting EJS as the templating engine
app.set("view engine", "ejs");
app.set("views", path.join(path.resolve(), "src", "views")); // Setting the directory for view templates

// User routes
app.get("/register", usersController.getRegister); // Route for displaying the registration page
app.get("/login", usersController.getLogin); // Route for displaying the login page
app.post("/login", usersController.postLogin); // Route for handling login form submission
app.get("/logout", usersController.logout); // Route for logging out the user
app.post("/register", usersController.postRegister); // Route for handling registration form submission

// Product routes
app.get("/", setLastVisit, auth, productsController.getProducts); // Route for displaying products, with last visit tracking and authentication
app.get("/add-product", auth, productsController.getAddProduct); // Route for displaying the add product page, with authentication

app.get("/update-product/:id", auth, productsController.getUpdateProductView); // Route for displaying the update product page, with authentication

app.post("/delete-product/:id", auth, productsController.deleteProduct); // Route for handling product deletion, with authentication

app.post(
  "/",
  auth,
  uploadFile.single("imageUrl"),
  validationMiddleware,
  productsController.postAddProduct
); // Route for handling product addition, with file upload, validation, and authentication

app.post("/update-product", auth, productsController.postUpdateProduct); // Route for handling product update, with authentication

// Starting the server on port 3000
app.listen(3000, () => {
  console.log("Server is running on port 3000");
});
