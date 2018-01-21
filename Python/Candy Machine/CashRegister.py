class CashRegister(object, cashOnHand=500):
    def __init__(self):
        if cashOnHand<0:
            cashOnHand=500
        self.cashOnHand=cashOnHand
        
    def currentBalance():
        return cashOnHand

    def acceptAmount(amount):
        cashOnHand+=amount

