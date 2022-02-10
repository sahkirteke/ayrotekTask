import React, { useEffect, useState } from "react";
import { deleteProduct, getProduct } from "../api/apiCalls";
import 'bootstrap/dist/css/bootstrap.min.css';
import ModalEdit from "./components/Modal";
import { Button } from "antd";

 const List = ()=> {
  
  const [products, setProducts]= useState(undefined); 
  const [selectedProduct, setSelectedProduct]= useState(null); 
  const [modalVisible, setModalVisible] = useState(false);
  
  useEffect(()=>{
      loadProducts();
  },[])

  const loadProducts= async () =>{
      try{
        const response = await getProduct();
        setProducts(response.data)
      }
      catch(error) {
        console.log(error);
      }
  } 
    
     
    return (
        <div>
            <ModalEdit products={products} selectedProduct={selectedProduct} modalVisible={modalVisible}  setModalVisible={setModalVisible}/>
            <div className="container ml-5" style={{marginTop: "80px"}}>
                <Button onClick={()=>{setSelectedProduct(null);setModalVisible(true);}}> Add Product</Button>
            <table className="table">
                <thead>
                <tr className="table-primary">
                    <th>Sıra</th>
                    <th> Product Name</th>
                    <th> Price</th>
                    <th> Product Type</th>
                    <th>Tax</th>
                    <th>Total Price</th>
                    <th>Date</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody >
                {products && products.map((product,index) => (
                    <tr className="table-secondary" key={index}>
                    <th >{index+1}</th>
                    <td>{product.productName}</td>
                    <td>{product.price}</td>
                    <td>{product.productType}</td>
                    <td>{product.tax}</td>
                    <td>{product.totalPrice}</td>
                    <td>{product.insertDate}</td>
                    <td  onClick={()=>{setSelectedProduct(index); setModalVisible(true);}}>Edit</td>
                    <td onClick={()=>{deleteProduct(product.id);  window.location.reload();} } >Delete</td>
                    </tr>
                ))}
                </tbody>
            </table>
            </div>
        </div>
    );
 
}
export default List;