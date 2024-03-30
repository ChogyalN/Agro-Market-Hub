import "../css/product.css";
import React, { useEffect, useState } from "react";
import axios from "axios";

function Product() {
  const [formData, setFormData] = useState({
    productName: "",
    productDesc: "",
    quantity: "",
    unitPrice: "",
    unit: "",
    availableDate: "",
  });

  useEffect(() => {
    console.log("inside");
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post("/api/v1/create_product", formData);
      console.log("Response:", response.data);
      console.log("inside handleSubmit");
      // Reset form fields after successful submission
      setFormData({
        productName: "",
        productDesc: "",
        quantity: "",
        unitPrice: "",
        unit: "",
        availableDate: "",
      });
      alert("Product data inserted successfully!");
    } catch (error) {
      console.error("Error:", error);
      alert("Failed to insert product data.");
    }
  };

  return (
    <>
      <div class="container">
        <h2>Insert Product Data</h2>
        <form id="insertForm">
          <div class="form-group">
            <label for="productName">Product Name:</label>
            <input
              type="text"
              id="productName"
              name="productName"
              onChange={handleChange}
              value={formData.productName}
            />
          </div>
          <div class="form-group">
            <label for="productDesc">Product Description:</label>
            <input
              type="text"
              id="productDesc"
              name="productDesc"
              onChange={handleChange}
              value={formData.productDesc}
            />
          </div>
          <div class="form-group">
            <label for="quantity">Quantity:</label>
            <input
              type="number"
              id="quantity"
              name="quantity"
              onChange={handleChange}
              value={formData.quantity}
            />
          </div>
          <div class="form-group">
            <label for="unitPrice">Unit Price:</label>
            <input
              type="number"
              id="unitPrice"
              name="unitPrice"
              step="0.01"
              onChange={handleChange}
              value={formData.unitPrice}
            />
          </div>
          <div class="form-group">
            <label for="unit">Unit:</label>
            <input
              type="text"
              id="unit"
              name="unit"
              value={formData.unit}
              onChange={handleChange}
            />
          </div>
          <div class="form-group">
            <label for="availableDate">Available Date:</label>
            <input
              type="date"
              id="availableDate"
              name="availableDate"
              onChange={handleChange}
              value={formData.availableDate}
            />
          </div>
          <button onClick={handleSubmit} type="submit">
            Submit
          </button>
        </form>
      </div>
    </>
  );
}

export default Product;
