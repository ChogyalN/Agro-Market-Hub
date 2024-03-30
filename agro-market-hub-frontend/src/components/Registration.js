import React from "react";
import { useState } from "react";
import axios from "axios";
import "../css/Registration.css";
function Registration() {
  const [formData, setFormData] = useState({
    name: "",
    location: "",
    address: "",
    phoneNo: "",
    dzongkhag: "",
    gewog: "",
    village: "",
    phoneNumber: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    axios
      .post("/api/v1/create_farmowner", formData, {
        headers: {
          "Content-Type": "application/json",
        },
      })
      .then((response) => {
        if (response.status === 200) {
          // Optionally, reset the form after successful submission
          setFormData({
            name: "",
            location: "",
            address: "",
            phoneNo: "",
            dzongkhag: "",
            gewog: "",
            village: "",
            phoneNumber: "",
          });
          alert("Form submitted successfully!");
        } else {
          throw new Error("Failed to submit form");
        }
      })
      .catch((error) => {
        console.error("Error:", error);
        alert("Failed to submit form");
      });
  };

  return (
    <div className="container">
      <h2>Registration Form</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="name">Name:</label>
          <input
            type="text"
            id="name"
            name="name"
            value={formData.name}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="location">Location:</label>
          <input
            type="text"
            id="location"
            name="location"
            value={formData.location}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="address">Address:</label>
          <input
            type="text"
            id="address"
            name="address"
            value={formData.address}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="phoneNo">Phone Number:</label>
          <input
            type="text"
            id="phoneNo"
            name="phoneNo"
            value={formData.phoneNo}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="dzongkhag">Dzongkhag:</label>
          <input
            type="text"
            id="dzongkhag"
            name="dzongkhag"
            value={formData.dzongkhag}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="gewog">Gewog:</label>
          <input
            type="text"
            id="gewog"
            name="gewog"
            value={formData.gewog}
            onChange={handleChange}
            required
          />
        </div>
        <div className="form-group">
          <label htmlFor="village">Village:</label>
          <input
            type="text"
            id="village"
            name="village"
            value={formData.village}
            onChange={handleChange}
            required
          />
        </div>

        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default Registration;
