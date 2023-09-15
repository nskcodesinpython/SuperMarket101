# SuperMarket Application

This Java application simulates a simple supermarket shopping experience. It allows users to scan items, manage inventory, and calculate total prices with special offers. The application is organized into several classes for better code structure and readability.

## Classes

### `Item`

The `Item` class represents a supermarket item. It has attributes such as item ID, name, price, and special price (if applicable). Items can be updated, and their details can be retrieved using various methods.

### `LoadDefaultItems`

The `LoadDefaultItems` class provides a method to load default items into the supermarket inventory. It creates instances of `Item` with predefined attributes and adds them to a list.

### `SpecialPrice`

The `SpecialPrice` class represents special pricing for items, indicating the quantity and price required to qualify for the special offer.

### `Cart`

The `Cart` class models the shopping cart, allowing users to scan items, remove items, and calculate the running total and final total based on special offers. It uses a `HashMap` to keep track of items and their quantities.

### `GatherInputFromTerminal`

The `GatherInputFromTerminal` class handles user input and provides methods for gathering and validating input for various actions, including scanning items and managing inventory.

### `InventoryService`

The `InventoryService` class manages the supermarket's inventory. It allows users to add, update, and delete items from the inventory. It also provides methods for checking item presence and validity.

### `ItemsService`

The `ItemsService` class handles item-related operations, such as checking item presence and quantity in the cart. It provides methods for retrieving items by name and checking item validity.

### `PrintToTerminal`

The `PrintToTerminal` class manages all the output messages displayed to the user. It formats and prints information related to items, the shopping cart, and inventory management.

### `SuperMarket`

The `SuperMarket` class acts as the main driver for the application. It provides a user interface for scanning items, managing inventory, and navigating through the supermarket experience.

## How to Run

1. Compile all the Java files.
2. Run the `SuperMarket` class to start the application.
3. Follow the on-screen prompts to interact with the supermarket.

## Features

- Scan items and add them to the cart.
- Calculate running totals and final totals, considering special pricing.
- Manage the supermarket's inventory by adding, updating, and deleting items.
- Display item lists, cart contents, and inventory information.

## Usage

1. Start the application, and you will be presented with the main menu.
2. Choose to either scan items or manage the inventory.
3. Scan items by entering their names one by one, and you can choose to add more items, proceed to checkout, or delete items.
4. For inventory management, you can add, update, or delete items as needed.
5. Special pricing offers can be added to items during inventory management.
6. Upon checkout, the application will display the cart contents and the total amount due.

## Additional Notes

- The application uses a simple text-based interface for interaction.
- Special pricing offers are represented as "X for Y" where X is the quantity required, and Y is the special price.
- The application assumes that all item names are single characters (e.g., "A," "B").
- Prices are handled as integers representing pence.
- The application provides error messages for invalid inputs.
