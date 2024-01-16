def calculate_income_tax(gross_salary):
    # Tax rate table
    income_ranges = [402, 110, 130, 3000, 16395, 29963, 50000]
    tax_rates = [0, 5, 10, 17.5, 25, 30, 35]

    cumulative_income = 0
    cumulative_tax = 0

    for i in range(len(income_ranges)):
        if gross_salary <= 0:
            break

        if gross_salary <= income_ranges[i]:
            cumulative_tax += (gross_salary * tax_rates[i] / 100)
            break

        taxable_amount = income_ranges[i]
        tax_payable = (taxable_amount * tax_rates[i] / 100)

        cumulative_income += taxable_amount
        cumulative_tax += tax_payable

        gross_salary -= taxable_amount

    net_salary = gross_salary + cumulative_income - cumulative_tax
    return cumulative_tax, net_salary


def main():
    try:
        gross_salary = float(input("Enter your gross monthly salary (in GH¢): "))
        if gross_salary < 0:
            raise ValueError("Invalid salary input. Salary cannot be negative.")
        
        tax_payable, net_salary = calculate_income_tax(gross_salary)

        print(f"\nIncome Tax Payable: GH¢ {tax_payable:.2f}")
        print(f"Net Monthly Salary: GH¢ {net_salary:.2f}")

    except ValueError as e:
        print(f"Error: {e}")
    except Exception as e:
        print(f"An unexpected error occurred: {e}")


if __name__ == "__main__":
    main()
