import React, { useState } from "react";
import "../css/footer.css";
import axios from "axios";

function Footer() {
  const [mail, setMail] = useState(false);
  const [formData, setFormData] = useState({
    to: "",
    subject: "",
    context: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const handleMail = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post("/api/v1/mail", formData);
      console.log("Response:", response.data);
      // Reset form fields after successful submission
      setFormData({
        to: "",
        subject: "",
        context: "",
      });
    } catch (error) {
      console.log(error);
    }
  };

  const mailSender = () => {
    setMail(true);
  };
  return (
    <>
      {mail ? (
        <div class="container">
          <h2>Email Form</h2>
          <form id="emailForm">
            <div class="form-group">
              <label for="to">To:</label>
              <input
                type="text"
                id="to"
                name="to"
                onChange={handleChange}
                placeholder="Recipient email address"
                required
              />
            </div>
            <div class="form-group">
              <label for="subject">Subject:</label>
              <input
                type="text"
                id="subject"
                name="subject"
                onChange={handleChange}
                placeholder="Email subject"
                required
              />
            </div>
            <div class="form-group">
              <label for="content">Content:</label>
              <textarea
                id="content"
                name="content"
                onChange={handleChange}
                placeholder="Email content"
                rows="12"
                required
              ></textarea>
            </div>
            <button
              onClick={() => handleMail()}
              type="submit"
              value="Send Email"
            >
              Send
            </button>
          </form>
        </div>
      ) : (
        <></>
      )}

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
              <li>
                <a onClick={() => mailSender()} href="#">
                  Mail us
                </a>
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
