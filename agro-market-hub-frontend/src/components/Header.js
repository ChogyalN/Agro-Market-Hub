import React from "react";
import "../css/header.css";

function Header() {
  return (
    <>
      <header>
        <nav class="navbar">
          <div class="logo">
            <h1>Your Logo</h1>
          </div>
          <ul class="nav-links">
            <li>
              <a href="#">Home</a>
            </li>
            <li>
              <a href="#">About</a>
            </li>
            <li>
              <a href="#">Services</a>
            </li>
            <li>
              <a href="#">Contact</a>
            </li>
          </ul>
        </nav>
      </header>
    </>
  );
}

export default Header;
