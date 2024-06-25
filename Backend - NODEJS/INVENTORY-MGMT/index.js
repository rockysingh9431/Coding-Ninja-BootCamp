import express from "express";
import ProductController from "./src/controllers/products.controller.js";

const server = express();

const productController = new ProductController();

server.get("/", productController.getProducts);
server.use(express.static("src/views"));

server.listen(5000, () => {
  console.log("server listening on port 5000");
});
