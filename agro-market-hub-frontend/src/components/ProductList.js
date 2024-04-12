import React, { useState, useEffect } from "react";
import axios from "axios";
import "../css/product.css";
import { useNavigate } from "react-router-dom";

function ProductList() {
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [id, setId] = useState(null);
  const navigate = useNavigate();
  const [update, setUpdated] = useState(true);
  const [toggle, setToggle] = useState(false);
  const [deleteIndex, setDeleteIndex] = useState(0);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await axios.get("/api/v1/getProducts");
        setProducts(response.data);
        setLoading(false);
      } catch (error) {
        setError(error.message);
        setLoading(false);
      }
    };

    fetchProducts();
  }, []);

  const deleteProduct = async () => {
    try {
      const response = await axios.delete(
        `/api/v1/deleteProductById/${products[deleteIndex].id}`
      );
      setProducts((prevProducts) => {
        // Create a copy of the previous state array
        const updatedProducts = [...prevProducts];
        updatedProducts.splice(deleteIndex, 1);
        setDeleteIndex(0);
        setToggle(false);
        return updatedProducts;
      });
    } catch (error) {
      console.log(error);
    }
  };
  const updateForm = (id) => {
    setId(id);
    navigate(`/product`, { state: { id: id, update: update } });
  };

  const dismissDialog = (index) => {
    setToggle(!toggle);
    setDeleteIndex(index);
  };

  return (
    <div className="product-table-container">
      <table className="product-table">
        <thead>
          <tr>
            <th>Product Name</th>
            <th>Description</th>
            <th>Quantity</th>
            <th>Unit Price</th>
            <th>Unit</th>
            <th>Available Date</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {toggle ? (
            <div className="dismiss-toggle">
              <h5>Are you sure you want to remove this list?</h5>
              <div id="dismiss-btn">
                <button onClick={() => deleteProduct()} className="dismiss-btn">
                  Yes
                </button>
                <button onClick={() => dismissDialog()} className="dismiss-btn">
                  Close
                </button>
              </div>
            </div>
          ) : (
            <></>
          )}

          {products.map((product, index) => (
            <tr key={index}>
              <td>{product.productName}</td>
              <td>{product.productDesc}</td>
              <td>{product.quantity}</td>
              <td>{product.unitPrice}</td>
              <td>{product.unit}</td>
              <td>{product.availableDate}</td>
              <td>{product.status}</td>
              <td>
                <button
                  onClick={(toggle) => dismissDialog(index)}
                  id="remove-btn"
                >
                  Remove
                </button>
              </td>
              <td>
                <button
                  onClick={() => updateForm(products[index].id)}
                  id="edit-btn"
                >
                  Update
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ProductList;
