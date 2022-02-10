import React, { useEffect } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { Form, Input, Button, Select, Modal } from "antd";
import { saveProduct, updateProduct } from "../../api/apiCalls";

const ModalEdit = ({
  modalVisible,
  setModalVisible,
  products,
  selectedProduct,
}) => {
  const { Option } = Select;
  const [form] = Form.useForm();

  useEffect(() => {
    form.setFieldsValue({
      productName:
        selectedProduct != null ? products[selectedProduct].productName : "",
      price: selectedProduct != null ? products[selectedProduct].price : "",
      productType:
        selectedProduct != null ? products[selectedProduct].productType : "",
    });
  }, [selectedProduct]);

  return (
    <Modal
      title={selectedProduct != null ? "Update" : "Add"}
      footer={null}
      visible={modalVisible}
      onOk={() => console.log("oldu")}
      onCancel={() => setModalVisible(false)}
    >
      <Form
        form={form}
        name="basic"
        labelCol={{ span: 8 }}
        wrapperCol={{ span: 16 }}
        onFinish={(values) => {
          if (selectedProduct != null)
            updateProduct({ id: products[selectedProduct].id, ...values });
          else saveProduct(values);
            setModalVisible(false);
          window.location.reload();
        }}
        autoComplete="off"
      >
        <Form.Item label="Product Name" name="productName">
          <Input />
        </Form.Item>

        <Form.Item label="Price" name="price">
          <Input />
        </Form.Item>

        <Form.Item
          label="Product Type"
          name="productType"
          valuePropName="checked"
          wrapperCol={{ offset: 8, span: 16 }}
        >
          <Select>
            <Option value="CAR">CAR</Option>
            <Option value="BOOK">BOOK</Option>
            <Option value="ELECTRONICS">ELECTRONICS</Option>
            <Option value="HOMESTUFF">HOMESTUFF</Option>
          </Select>
        </Form.Item>

        <Form.Item wrapperCol={{ offset: 8, span: 16 }}>
          <Button type="primary" htmlType="submit">
            Submit
          </Button>
        </Form.Item>
      </Form>
    </Modal>
  );
};

export default ModalEdit;
