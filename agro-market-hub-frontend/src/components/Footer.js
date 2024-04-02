import React from "react";
import "../css/footer.css";

function Footer() {
  return (
    <>
      <footer class="dark-footer" id="footer">
        <div class="footer-container">
          {/* <div class="footer-column">
            <h3>About Us</h3>
            <p>
              Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do
              eiusmod tempor incididunt ut.
            </p>
          </div> */}
          <div class="footer-column">
            <h3>Contact Us</h3>
            <p>Email: info@example.com</p>
            <p>Phone: +123-456-7890</p>
            <p>Address: 123 Main Street, City, Country</p>
          </div>
          <div class="footer-column">
            <h3>Quick Links</h3>
            <ul>
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
          </div>
          <div class="footer-column">
            <h3>Follow Us</h3>
            <ul class="social-icons">
              <li>
                <a href="https://www.facebook.com/">
                  <img src="https://img.icons8.com/?size=96&id=118497&format=png" />
                </a>
              </li>
              <li>
                <a href="https://www.instagram.com/">
                  <img src="https://img.icons8.com/?size=96&id=32323&format=png" />
                </a>
              </li>
              <li>
                <a href="https://twitter.com/">
                  <img src="https://img.icons8.com/?size=96&id=13963&format=png" />
                </a>
              </li>
              <li>
                <a href="https://web.telegram.org/a/">
                  <img src="https://img.icons8.com/?size=96&id=63306&format=png" />
                </a>
              </li>
            </ul>
          </div>
        </div>
        <div class="bottom-footer">
          <p>&copy; 2024 Your Company. All rights reserved.</p>
        </div>
      </footer>
    </>
  );
}

export default Footer;
