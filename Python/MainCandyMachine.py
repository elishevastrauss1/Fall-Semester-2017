class CashRegister(object):
    def __init__(self, cashOnHand=500):
        if cashOnHand<0:
            cashOnHand=500
        self.cashOnHand=cashOnHand
        
    def currentBalance(self):
        return self.cashOnHand

    def acceptAmount(self, amount):
        self.cashOnHand+=amount

class Dispenser(object):
    def __init__(self, numberOfItems, cost):
        if numberOfItems<50:
            numberOfItems=50
        if cost<50:
            cost=50
        self.numberOfItems=numberOfItems
        self.cost=cost
    

    def getCount(self):
        return self.numberOfItems

    def getProductCost(self):
        return self.cost

    def makeSale():
        numberOfItems-=1


def showSelection():
    print("***Welcome to Elisheva's Candy Shop***")
    print("To select an item, enter\n"+
          "1 for Candy\n"+
          "2 for Chips\n"+
          "3 for Gum\n"+
          "4 for Cookies\n"+
          "9 to exit\n")
    numChoice=input()
    return numChoice


def sellProduct(product, cashRegister):
    numProducts=product.getCount()
    if numProducts<=0:
        print("Product Sold Out")
    else:
        cost=product.getProductCost()
        print(cost)
        while cost>0:
            money=int(input("Enter " + str(cost) +" cents: " ))
            cost-=money
            cashRegister.acceptAmount(money)
        print("Collect your item at the bottom and enjoy!")
#main
cashRegister=CashRegister()
candy=Dispenser(100,50)
chips=Dispenser(100,65)
gum=Dispenser(75,45)
cookies=Dispenser(100,85)
numChoice=showSelection()
while numChoice!="9":
    if numChoice=="1":
        sellProduct(candy, cashRegister)
        numChoice=showSelection()
        
    elif numChoice=="2":
        sellProduct(chips, cashRegister)
        numChoice=showSelection()

    elif numChoice=="3":
        sellProduct(gum, cashRegister)
        numChoice=showSelection()

    elif numChoice=="4":
        sellProduct(cookies, cashRegister)
        numChoice=showSelection()
    else:
        print("Invalid Selection")
        numChoice=showSelection()











    
    
