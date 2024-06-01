import datetime


filename = 'laptop.txt'


while True:
    print("Welcome to the Laptop Shop!")
    print("Do you want to order or sell a laptop?")
    choice = input("Enter 'o' for order or 's' for sell or 'd' for display and 'e' for exit: ")
    
    if choice == "e":
        break
    
    

    elif choice == "d":
        with open(filename, "r") as file:
            laptops_data = []
            for line in file:
                laptop = line.strip().split(", ")
                name, brand, price, quantity, processor, graphics_card = laptop
                laptops_data.append(laptop)
        
        # Display the list of available laptops
                print("\nAvailable laptops")
                print(f"Name: {name},\n Brand: {brand},\n Price: {price},\n Quantity: {quantity},\n Processor: {processor},\n Graphics Card: {graphics_card}")




    elif choice == "o":
    
        # import order_laptop from order_laptop.py
        import order_laptop 
    
   # Read the data from the text file
        def read_laptops(filename):
            with open(filename, "r") as file:
                laptops_data = []
                for line in file:
                    laptop = line.strip().split(", ")
                    name, brand, price, quantity, processor, graphics_card = laptop
                    laptops_data.append(laptop)
        
                # Display the list of available laptops
                    print("\nAvailable laptops")
                    print(f"Name: {name},\n Brand: {brand},\n Price: {price},\n Quantity: {quantity},\n Processor: {processor},\n Graphics Card: {graphics_card}")
            return laptops_data
        laptops = read_laptops('laptop.txt')

        
        
         
            
        
    elif choice == "s":
    
     # import sale_laptop from sale_laptop.py
     
        import sale_laptop
    
     # Read the data from the text file
        def read_laptops(filename):
            with open(filename, "r") as file:
                laptops_data = []
                for line in file:
                    laptop = line.strip().split(", ")
                    name, brand, price, quantity, processor, graphics_card = laptop
                    laptops_data.append(laptop)
        
                # Display the list of available laptops
                    print("\nAvailable laptops")
                    print(f"Name: {name},\n Brand: {brand},\n Price: {price},\n Quantity: {quantity},\n Processor: {processor},\n Graphics Card: {graphics_card}")
            return laptops_data
        laptops = read_laptops('laptop.txt')
    
 
    # if invalid choices is entered
     
         
    else:
        print("Invalid choice. Please try again.")
        

