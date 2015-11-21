# Cart Endpoints

----
## POST /carts/create
Create a new cart and returns the identifier.

### Resource Information

Response format: JSON.

### Parameters
None.

### Example Request

POST [http://shopping.com/carts/create] (http://shopping.com/carts/create)

### Example Result

    {
      "id" : 1
    }  
 
## GET /carts/{cart-id}
Returns details of a cart by ID.

### Resource Information

Response format: JSON.

### Parameters
Providing **cart-id** is required.

* **cart-id:** The ID of the cart.

### Example Request

POST [http://shopping.com/carts/2] (http://shopping.com/carts/2)

### Example Result

    {
      "id" : 2,
      "items" : [
        {
          "price" : 10000,
          "capacity" : 70
        },
        {
          "price" : 0,
          "screenSize" : 42
        }
      ] 
    }


## GET /carts/{cart-id}/items
Get list of items that have already been added to the cart.

### Resource Information

Response format: JSON.

### Parameters
Providing **cart-id** is required.

* **cart-id:** The ID of the cart.

### Example Request

POST [http://shopping.com/carts/2/items] (http://shopping.com/carts/2/items)

### Example Result

    {
      {
        "price" : 10000,
        "capacity" : 70
      },
      {
        "price" : 0,
        "screenSize" : 42
      }
    }

## POST /carts/{cart-id}/add
Add an item to the cart.

### Parameters
Providing **cart-id** and **item-id**  is required.

* **cart-id:** The ID of the cart.
* **item-id:** The ID of the item.

### Example Request

POST [http://shopping.com/carts/1/add] (http://shopping.com/carts/1/add)