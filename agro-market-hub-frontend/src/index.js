import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
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
import Landing from "./components/Landing.js";
import DropDown from "./components/DropDown.js";
import Chart from "./components/Chart.js";
import SignUp from "./components/SignUp.js";
import CustomizedTables from "./components/MUI/CustomizedTables.js";
import OutlinedAlerts from "./components/MUI/OutlinedAlerts.js";
import Dialog from "./components/MUI/Dialog.js";
import Login from "./components/Login.js";
import CookieTry from "./components/MUI/CookieTry.js";

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route path="/" element={<Layout />}>
      
      <Route path="" element={<Landing />} />
      <Route path="product" element={<Product />} />
      <Route path="productList" element={<ProductList />} />
      <Route path="landing" element={<Landing />} />
      <Route path="dropdown" element={<DropDown />} />
      <Route path="chart" element={<Chart />} />
      <Route path="signup" element={<SignUp />} />
      <Route path="table" element={<CustomizedTables />} />
      <Route path="alert" element={<OutlinedAlerts />} />
      <Route path="dialog" element={<Dialog />} />
      <Route path="login" element={<Login />} />
      <Route path="cookies" element={<CookieTry />} />
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
