import React from "react";
import "../css/dropDown.css";

function DropDown() {
  return (
    <div className="App">
      <h1>Programming Language Menu</h1>
      <div className="dropdown">
        <h3 className="">Programming Languages</h3>

        <div className="dropdown-content">
          <a href="#">Java</a>
          <a href="#">Ruby</a>
          <a href="#">JavaScript</a>
          <a href="#">HTML/CSS</a>
          <a href="#">React</a>
          <a href="#">React Native</a>
        </div>
      </div>
    </div>
  );
}

export default DropDown;
