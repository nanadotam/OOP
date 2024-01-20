# Main logic
def calculate_tax(gross_income):
    # Function to calculate income tax and net salary using the tax rates published by the GRA
    remaining_income = gross_income
    tax_payable = 0

    # Calculate tax for the first bracket
    if remaining_income <= 402:
        tax_payable += remaining_income * 0
    else:
        tax_payable += 402 * 0
        remaining_income -= 402

        # Calculate tax for the second bracket
        if remaining_income <= 110:
            tax_payable += remaining_income * 0.05
        else:
            tax_payable += 110 * 0.05
            remaining_income -= 110

            # Calculate tax for the third bracket
            if remaining_income <= 130:
                tax_payable += remaining_income * 0.10
            else:
                tax_payable += 130 * 0.10
                remaining_income -= 130

                # Calculate tax for the fourth bracket
                if remaining_income <= 3000:
                    tax_payable += remaining_income * 0.175
                else:
                    tax_payable += 3000 * 0.175
                    remaining_income -= 3000

                    # Calculate tax for the fifth bracket
                    if remaining_income <= 16395:
                        tax_payable += remaining_income * 0.25
                    else:
                        tax_payable += 16395 * 0.25    
                        remaining_income -= 16395          

                        # Calculate tax for the sixth bracket
                        if remaining_income <= 29963:
                            tax_payable += remaining_income * 0.30
                        else: 
                            tax_payable += 29963 * 0.30
                            remaining_income -= 29963

                            # Calculate tax for the seventh bracket 
                            if remaining_income <= 50000:
                                tax_payable += remaining_income * 0.35
                            else:
                                tax_payable += 50000 * 0.35
                                remaining_income -= 50000


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
    result = calculate_tax(gross_income)
    tax = result[0]
    net_salary = result[1]

    # Display results
    print(f"\nGross Monthly Salary: GHS {round(gross_income, 2)}")
    print(f"Income Tax: GHS {round(tax, 2)}")
    print(f"Net Monthly Salary: GHS {round(net_salary, 2)}")


if __name__ == "__main__":
    main()
