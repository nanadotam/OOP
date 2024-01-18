'''
1. Get user input
2. Create a tax table
3. Calculate the user's gross income
'''

# Function to calculate income tax and net salary using the tax rates published by the GRA
def calculate_tax(gross_income):
    remaining_income = gross_income
    # Tax for first bracket
    tax_payable = 0

    # Calcualting tax for the first bracket
    if remaining_income <= 402:
        tax_payable += remaining_income * 0
    else:
        tax_payable += 402 * 0
        remaining_income -= 402
    