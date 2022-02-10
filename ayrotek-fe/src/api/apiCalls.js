import axios from "axios";


export const getProduct= () => {
    return axios.get(`/product/all`);
}; 

export const deleteProduct = id => {
  console.log(id)
    return axios.delete(`/product/delete/${id}`);
  };

  export const updateProduct =(product)=>{
      return axios.put(`/product/update/${product.id}`, product)
  }

  export const saveProduct =(product) => {
    return axios.post(`/product/save` , product);
  }