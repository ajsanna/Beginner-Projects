
# Final Project CS2520
# By: Alexander J Sanna
# Due 12/15/2023

import time

class itemToPurchase():
	def __init__(self, item_name = "", item_price = 0.0, item_quantity = 0):
		self.item_name = item_name
		self.item_price = item_price
		self.item_quantity = item_quantity

	def print_item_cost(self):
		print(self.item_name + ": ")
		print(str(self.item_quantity) + " at $" + str(self.item_price) + " each:" )
		print(" Price: $" + str(self.item_price * self.item_quantity))
	
#end ItemToPurchase

def main_part_1():
	print("Welcome to the Online Shopping Simulator")
	print("Created by: Alex Sanna (ajsanna@cpp.edu)")
	print()
	#print("How many items would you like to add to your cart?")
	items = []
	total_cost = 0.0
	num_items = int(input("How many items would you like to add to your cart? "))
	for x in range(1, num_items+1):
		print()
		print("Item: " + str(x))
		name = input("Enter the name of the item: ")
		price = float(input("Enter the price of the " + name + " "))
		count = int(input("How many? "))
		item = itemToPurchase(name, price, count)
		items.append(item) 
		print(name + " added to the shopping cart. (" + str(count) + " at $" + str(price) + " each.)")
		total_cost += (count * price)

	print("The total shopping cart value is: $" + str(total_cost))
#end main()

#main_part_1()

#BEGIN PART 2:
class specific_item(itemToPurchase):

	def __init__(self, name, price = 0.0, quantity = 0, description = "none"):
		super().__init__(name, price, quantity)
		self.description = description
	
	def print_item_description(self):
		print(self.name + ":")
		print(self.description)


class Shopping_Cart():

	def __init__(self, name = "none", date = "Jan 1st, 2016"):
		self.customer_name = name
		self.current_date = date
		self.cart_items = []
	
	def add_item(self, item: itemToPurchase):
		self.cart_items.append(item)
	
	def remove_item(self, target: str):
		if self.get_num_items_in_cart == 0:
			print("Cart is empty.")
			return
		
		for x in self.cart_items:
			if x.item_name == target:
				self.cart_items.remove(x)
				return

		print("Item not found. Nothing Removed.")

	
	def modify_item(self, target:itemToPurchase, quantity):
		for x in self.cart_items:
			if x.item_name == target.item_name:
				item_name = x.item_name
				item_cost = x.item_price
				desc = x.description
				self.cart_items.remove(x)
				self.add_item(specific_item(item_name, item_cost, quantity, desc))
				return
			
		print("Item not found, nothing edited.")


	def get_num_items_in_cart(self):
		return len(self.cart_items)

	def get_cost_of_cart(self):
		total_cost = 0
		for x in self.cart_items:
			total_cost += ( x.item_price * x.item_quantity)
		
		return total_cost
	
	def print_total(self):
		print(self.customer_name +"'s Shopping Cart - " + self.current_date)
		print("Number of Items: " + str(self.get_num_items_in_cart()))
		print()
		for x in self.cart_items:
			print(x.item_name + " " + str(x.item_quantity) + " at $" + str(x.item_price) + " each.")

		print()
		print("Total: " + str(self.get_cost_of_cart()))


	def print_descriptions(self):
		print(self.customer_name +"'s Shopping Cart - " + self.current_date)
		print()
		print("Item Descriptions:")
		for x in self.cart_items:
			print(x.item_name + ": " + x.description)

		
def main_part_2():
	print()
	print("-" * 20)
	print("Shopping Cart Simulator Part 2")
	shopper_name = input("Please enter your name.")
	date = input("Please Enter the date: (Month XX, XXXX)")
	
	MAIN_SHOPPING_CART = Shopping_Cart(shopper_name, date)
	print()
	valid_cmds =  {'a': "Add", 'r': "Remove", 'c': "Modify", 'i': "Info", 'o': "Total"}
	print("Shopper name: " + MAIN_SHOPPING_CART.customer_name)
	print("Date: " + MAIN_SHOPPING_CART.current_date)
	print()
	while True:
		print_menu()
		print()
		cmd = str(input("Enter your request:"))
		if cmd.lower() == 'q':
			break
		
		if cmd.lower() in valid_cmds:
			print(valid_cmds.get(cmd.lower()) + "Selected.")
			excecute_menu(cmd.lower(), MAIN_SHOPPING_CART)

		else:
			print("INVALID COMMAND PLEASE TRY AGAIN")
			time.sleep(3)

	print("Have a nice Day!")
		


def print_menu():
	print("MENU \na - Add item to cart\nr - Remove item from cart\nc - Change item quantity")
	print("i - Output items' descriptions\no - Output shopping cart\nq - Quit")

def excecute_menu(cmd: str, cart: Shopping_Cart):
	if cmd == 'a':
		name = input("Enter the name of the item: ")
		price = float(input("Enter the price of the " + name + " "))
		count = int(input("How many? "))
		desc = input("Enter a brief description: ")
		item = specific_item(name, price, count, desc)
		cart.add_item(item)
	
	elif cmd == 'r':
		name = input("Enter the name of the item you'd like to remove: ")
		cart.remove_item(name)
	
	elif cmd == 'c':
		name = input("Enter the name of the item: ")
		#price = float(input("Enter the price of the " + name + " "))
		count = int(input("How many? "))
		#desc = input("Enter a brief description: ")
		item = specific_item(name = name, quantity = count)
		cart.modify_item(item, count)
	
	elif cmd == 'i':
		cart.print_descriptions()
	
	elif cmd == 'o':
		cart.print_total()


main_part_1()		
main_part_2()

	