import React from "react";
import "../css/header.css";
import { Link } from "react-router-dom";

function Header() {
  return (
    <>
      <header>
        <nav class="navbar">
          <div class="logo">
            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbuBD3DF9Z7DsEFhGcx9hREKZZqyND8YSYgj4-wXS07A&s" />
          </div>
          <ul class="nav-links">
            <Link to="landing">
              <li>
                <a href="">Home</a>
              </li>
            </Link>
            <Link to="productList">
              <li>
                <a href="#">View Products</a>
              </li>
            </Link>
            <Link to="product">
              <li>
                <a href="#">Add Product</a>
              </li>
            </Link>
            <li>
              <a href="#footer">Contact</a>
            </li>
          </ul>
        </nav>
      </header>
    </>
  );
}

export default Header;
