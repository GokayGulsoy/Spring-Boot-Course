# Project Scope and Example Use Cases

Project covers development of an Spring MVC application that manages product categories and products on a shopping site. 

It fullfills the following use cases:
1. Creating product category
2. Deleting product category
3. Changing the name of existing product category
4. Listing existing category/categories
5. Adding new product to existing product category
6. Deleting existing product from category
7. Updating name and/or price of products
8. Listing existing product/products

All users are allowed to list products and product categories, whereas only users whose role is `ADMIN`
allowed to create, update, and delete product or product categories (`Basic Authentication` used). 
Example usage of API for GET, POST, PUT, and DELETE requests is given in the following seciton. 

In order to run application, execute the following command in terminal from spring boot project's root directory: `.\mvnw spring-boot:run`

NOTE: In order to execute POST, PUT, and DELETE requests `username: admin` and `password: test` must be provided in POSTMAN's authorization tab with Basic Authentication, for GET requests èither of the `username: admin` and `password: test`
or `username: user` and `password: test` username-password pairs can be used.

## Example Scenario for Testing REST API with POSTMAN

First we create **Electronic appliances** product category by making POST request to URL: `http://localhost:8080/productcategories`: 

![POST request to productcategories end point to create Electronic Appliances product category](Images/POST_request_to_product_category_controller_1.png)

![Response from POST request to create Electronic Appliances product category](Images/POST_request_to_product_category_controller_response_1.png)

Creating **Home Appliances** product category by making POST request to URL: `http://localhost:8080/productcategories`

![POST request to productcategories end point to create Home Appliances product category](Images/POST_request_to_product_category_controller_2.png)

![POST request to productcategories end point to create Home Appliances product category](Images/POST_request_to_product_category_controller_response_2.png)

After we create product categories with POST requests, we will create products Playstation 4 and Vacuum Cleaner in Electronic Appliances product category by making POST requests to URL: `http://localhost:8080/products?categoryId=1`

![POST request to products end point to create Playstation 4 product in Electronic Appliances category](Images/POST_request_to_product_controller_1.png)

![Response from POST request to create Playstation 4 in Electronics Appliances product category](Images/POST_request_to_product__controller_response_1.png)

![POST request to products end point to create Vacuum Cleaner product in Electronic Appliances category](Images/POST_request_to_product_controller_2.png)

![Response from POST request to create Vacuum Cleaner in Electronics Appliances product category](Images/POST_request_to_product__controller_response_2.png)

we will also create products Toaster and Oven in Home Appliances product category by making POST request to URL:  `http://localhost:8080/products?categoryId=2` 

![POST request to products end point to create Toaster product in Home Appliances category](Images/POST_request_to_product_controller_3.png)

![Response from POST request to create Toaster product in Home Appliances product category](Images/POST_request_to_product__controller_response_3.png)

![POST request to products end point to create Oven product in Home Appliances category](Images/POST_request_to_product_controller_4.png)

![Response from POST request to create Toaster product in Home Appliances product category](Images/POST_request_to_product__controller_response_4.png)

we will make GET requests to products and productcategories end points to see whether product categories and products are created with URLs: `http://localhost:8080/products` and  `http://localhost:8080/productcategories`

![GET request to products end point in order to see created products](Images/GET_request_to_product_controller_1.png)

![Response from GET request to products end point to see created products](Images/GET_request_to_product_controller_response_1.png)

![GET request to productcategories end point in order to see created product categories](Images/GET_request_to_product_category_controller_2.png)

![Response from GET request to productcategories end point to see created product categories](Images/GET_request_to_product_category_controller_response_2.png)

we will add one more product to Electronic Appliances category which is Xbox Series S with price 20000.5 by making POST request to URL: `http://localhost:8080/products/1?categoryId=1` 

![POST request to products end point to create Xbox Series S product in Electronic Appliances category](Images/POST_request_to_product_controller_5.png)

![Response from POST request to create Xbox Series S product in Electronic Appliances product category](Images/POST_request_to_product_controller_response_5.png)

we will now make PUT request to products and productcategories to update Playstation 4 product's price from 15000.5 to 22000.5 and change the Electronic Appliances categorie's name to Electronic Gadgets with URLs: `http://localhost:8080/products/1?categoryId=1` and `http://localhost:8080/productcategories/1`

![PUT request to products end point in order to update Playstation 4s price](Images/PUT_request_to_product_controller__1.png)

![Response from PUT request to products end point to update Playstation 4s price](Images/PUT_request_to_product_controller_response_1.png)

![PUT request to productcategories end point in order to update Electronic Appliances categorie's name](Images/PUT_request_to_product_category_controller_response_1.png)

we will finally make a DELETE request to delete Xbos Series X product and Home Appliances product category with URLs: `http://localhost:8080/products/5` and `http://localhost:8080/productcategories/2` 

![Delete request to products end point in order to delete Xbox Series S product](Images/DELETE_request_to_product_category_controller_1.png)

![Response from Delete request to products end point to delete Xbox Series S product](Images/DELETE_request_to_product_controller_response_1.png)

![Delete request to productcategories end point in order to delete Home Appliances product category](Images/DELETE_request_to_product_category_controller_1.png)

![Response from Delete request to productcategories end point to delete Home Appliances product category](Images/DELETE_request_to_product_category_controller_response_1.png)

## END OF REST API TESTING
