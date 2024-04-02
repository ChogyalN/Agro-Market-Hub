import "../css/product.css";
import React, { useEffect, useState } from "react";
import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";

function Product(props) {
  const [id, setId] = useState(null);
  const [update, setUpdate] = useState(false);
  const location = useLocation();
  const navigate = useNavigate();

  useEffect(() => {
    if (location.state) {
      setId(location.state.id);
      setUpdate(location.state.update);
    }
  }, [location.state]);

  const [formData, setFormData] = useState({
    productName: "",
    productDesc: "",
    quantity: "",
    unitPrice: "",
    unit: "",
    availableDate: "",
  });

  useEffect(() => {
    console.log(console.log(update));
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

  const updateProduct = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.put(
        `/api/v1/updateProducts/${id}`,
        formData
      );
      console.log("Response:", response.data);
      console.log("inside updateProduct");
      // Reset form fields after successful submission
      setFormData({
        productName: "",
        productDesc: "",
        quantity: "",
        unitPrice: "",
        unit: "",
        availableDate: "",
      });
      alert("Product data updated successfully!");
      setUpdate(false);
      navigate("/");
    } catch (error) {
      console.error("Error:", error);
      alert("Failed to update product data.");
    }
  };

  return (
    <>
      <div class="" id="product-container">
        {update ? (
          <h2 id="product-add">Update Product Data</h2>
        ) : (
          <h2 id="product-add">Insert Product Data</h2>
        )}
        <div id="product-content">
          <div class="inputProduct-sidediv">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/e/e9/Centres_of_origin_and_spread_of_agriculture.svg/2560px-Centres_of_origin_and_spread_of_agriculture.svg.png" />
            <h3>
              Join our agricultural community! Register now to unlock a world of
              sustainable farming solutions and connect with fellow enthusiasts
            </h3>
          </div>

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

            {update ? (
              <button onClick={updateProduct} type="submit">
                Update
              </button>
            ) : (
              <button onClick={handleSubmit} type="submit">
                Submit
              </button>
            )}
          </form>
        </div>
      </div>
    </>
  );
}

export default Product;
