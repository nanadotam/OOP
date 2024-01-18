'''
1. Get user input
2. Create a tax table
3. Calculate the user's gross income
'''

# foolish line

def calculate_tax(gross_income):
    # Function to calculate income tax and net salary using the tax rates published by the GRA
    chargable_income = [402, 110, 130, 3000, 16395, 29963, 50000]    #in GHS
    tax_rates = [0, 0.05, 0.10, 0.175, 0.25, 0.30, 0.35]    #in percentages

    remaining_income = gross_income
    tax_payable = 0

    for i in range(len(chargable_income)):
        if remaining_income <= 0:
            break

        # Determine taxable amount for the current tax_bracket
        taxable_amount = min(remaining_income, chargable_income[i])

        # Calculate tax for the current bracket and total tax payable
        tax = taxable_amount * tax_rates[i]
        tax_payable += tax

        # Update remaining income after accounting for the current bracket
        remaining_income -= taxable_amount

        # Calculate net salary after tax deductions
        net_salary = gross_income - tax_payable
        return tax_payable, net_salary

# Main function
def main():
    # Get gross monthly salary from user
    gross_income = float(input("Enter your gross monthly salary in GHS: "))
    if gross_income < 0:
        raise ValueError("Salary cannot be negative.")
    
    # Calculate tax and net salary using the calculate_tax function
    tax, net_salary = calculate_tax(gross_income)

    # Display results
    print(f"\nGross Monthly Salary: GHS {round(gross_income, 2)}")
    print(f"Income Tax: GHS {round(tax, 2)}")
    print(f"Net Monthly Salary: GHS {round(net_salary, 2)}")

# Run the program if it is the main module
if __name__ == "__main__":
    main()
