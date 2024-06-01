import datetime

filename = "laptop.txt"

def update_laptop_file(laptop_name, brand_name, quantity):
    # Read the contents of the file
 try:  
    with open(filename, 'r') as file:
        lines = file.readlines()

    # Update the quantity of the purchased laptop
    updated_lines = []
    for line in lines:
        laptop = line.strip().split(", ")
        if laptop[0] == laptop_name and laptop[1] == brand_name:
            updated_quantity = int(laptop[3]) + quantity
            if updated_quantity < 0:
                print("Quantity cannot be less than 0.")
                return False
            laptop[3] = str(updated_quantity)
            updated_line = ", ".join(laptop) + "\n"
            updated_lines.append(updated_line)
        else:
            updated_lines.append(line)

    # Write the updated contents back to the file
    with open(filename, 'w') as file:
        file.writelines(updated_lines)
        
 except Exception as e:
        print("An error occurred while updating the laptop file:", str(e))
        return False

def generate_order_invoice(distributor_name, laptop_name, brand_name, quantity):
 try:
    # Create a unique filename for the invoice based on the current date and time
    invoice_filename = f"order_invoice.txt"

    if quantity <= 0:
        print("Quantity must be greater than 0.")
        return None


    # Check if the requested quantity is available
    with open(filename, "r") as file:
        lines = file.readlines()
        for line in lines:
            laptop = line.strip().split(", ")
            if laptop[0] == laptop_name and laptop[1] == brand_name:
                if int(laptop[3]) >= quantity:
                    price = int(laptop[2][1:]) * quantity

                    # Update the quantity in the laptop file
                    update_laptop_file(laptop_name, brand_name, quantity)
                    if not update_laptop_file:
                        return None

                    # Write the invoice header
                    with open(invoice_filename, "w") as file:
                        file.write("\n\norder Invoice of laptop\n\n")
                        file.write(f"Distributor Name: {distributor_name}\n")
                        file.write(f"Date of Purchase: {datetime.datetime.now().strftime('%Y-%m-%d %H:%M:%S')}\n\n")

                        # Write the item details
                        file.write(f"laptop Name: {laptop_name}\n")
                        file.write(f"laptop Brand: {brand_name}\n")
                        file.write(f"Quantity: {quantity}\n\n")
                        file.write(f"Total Amount: ${price}\n\n")

                        # Write the vat amount
                        vat_amount = 0.13 * price
                        file.write(f"Total vat: ${vat_amount}\n\n")

                        # Write the gross amount
                        gross_amount = price+vat_amount
                        file.write(f"Total gross: ${gross_amount}\n\n")
                        file.write("Thank you. visit again")
                    file.close()

                    # Return the filename of the invoice
                    return invoice_filename
                else:
                    print("Quantity is invalid.")
                    return None
        print("Laptop or brand name not matched.")
        return None
    
 except Exception as e:
        print("An error occurred while generating order invoice:", str(e))
        return False
                           


laptop_name = input('Enter laptop name: ')
brand_name = input('Enter brand name: ')
quantity = int(input('Enter quantity: '))
distributor_name = input('Enter distributor name: ')

invoice_filename = generate_order_invoice(distributor_name, laptop_name, brand_name, quantity)
if invoice_filename:
    print(f"Invoice generated: {invoice_filename}")
    print(f"Order successful.")
else:
    print("Order failed.")    
