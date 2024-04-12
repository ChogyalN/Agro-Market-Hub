import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import App from "./App";
import reportWebVitals from "./reportWebVitals";
import {
  Route,
  RouterProvider,
  createBrowserRouter,
  createRoutesFromElements,
} from "react-router-dom";
import Product from "./components/Product.js";
import ProductList from "./components/ProductList.js";
import Layout from "./components/Layout.js";
import Login from "./components/Login.js";
import Landing from "./components/Landing.js";
import DropDown from "./components/DropDown.js";
import Chart from "./components/Chart.js";

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route path="/" element={<Layout />}>
      <Route path="" element={<Landing />} />
      <Route path="product" element={<Product />} />
      <Route path="productList" element={<ProductList />} />
      <Route path="landing" element={<Landing />} />
      {/* <Route path="user/:userid" element={<User />} /> */}
      <Route path="dropdown" element={<DropDown />} />
      <Route path="chart" element={<Chart />} />
    </Route>
  )
);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
