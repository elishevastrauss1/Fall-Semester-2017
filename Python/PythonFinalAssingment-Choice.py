def Choice():
    choice=str(input("""
    Enter a number to:
        1-Play the Game
        2-See the High Score
        3-Quit the Game
        """))
    return choice

def NewLetters(lettersAvail,indexOfNewLetter):
    import random
    letters=['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
    i=0
    for numbers in indexOfNewLetter:
        randomNum=random.randrange(0,26)
        lettersAvail[numbers]=letters[randomNum]
    return lettersAvail

def GetLetters(lettersAvail):
    i=1
    while i<=20:
        if i==5 or i==10 or i==15:
            print(lettersAvail[i])
            print("--------------")
        elif i==20:
            print(lettersAvail[i])
        else:
            print(lettersAvail[i], "|", end="")
        i+=1

def CheckIfLettersInChoice(word, lettersAvail):
    copyLettersA=lettersAvail[:]
    indexOfLetterUsed=[]
    for wordLetter in word:
        index=-1
        for letters in copyLettersA:
            index+=1
            if index in indexOfLetterUsed:
                continue
            if letters==wordLetter:
                indexOfLetterUsed.append(index)
                break

    counter=0
    for index in indexOfLetterUsed:
        index-=counter
        copyLettersA.remove(copyLettersA[index])
        counter+=1
        

    if len(lettersAvail)-len(copyLettersA)==len(word):
        NewLetters(lettersAvail, indexOfLetterUsed)
        #print("Word uses letters of choice")
        return True
        
    else:
        print("Word doesn't use correct letters")
        return False
def EnterHighScores(points):
    try:
        highScoresList=[]
        highScores=open("highScores.txt", "r")
        for score in highScores:
            highScoresList.append(int(score.strip()))
        highScores.close()
        import os
        os.remove("highScores.txt")

        highNamesList=[]
        highNames=open("highNames.txt", "r")
        for name in highNames:
            highNamesList.append(name.strip())
        highNames.close()
        os.remove("highNames.txt")

        isHighScore=False

        if len(highScoresList)<10 and points>0:
                for score in highScoresList:
                    if points>score:
                        index=highScoresList.index(score)
                        highScoresList.insert(index, points)
                        print("This is a high score!!!!")
                        isHighScore=True
                        newName=input("Enter your name\n")
                        highNamesList.insert(index, newName)
                        break
                        
                if not isHighScore:
                    index=len(highScoresList)   
                    highScoresList.insert(index, points)
                    print("This is a high score!!!!")
                    isHighScore=True
                    newName=input("Enter your name\n")
                    highNamesList.insert(index, newName)
                    
                
        if isHighScore==False:
            for score in highScoresList:
                if points>score:
                    index=highScoresList.index(score)
                    print(index)
                    highScoresList.insert(index,points)
                    print("This is a high score!!!!")
                    isHighScore=True
                    newName=input("Enter your name\n")
                    highNamesList.insert(index, newName)
                    break
            
            
        if not isHighScore:
            print("Not a highScore")
                
            
    except FileNotFoundError:
        highScoresList=[points]
        print("This is a high score!!!!")
        newName=input("Enter your name\n")
        highNamesList=[newName]

    
    if len(highScoresList)>10:
        highScoresList.remove(highScoresList[10])
        highNamesList.remove(highNamesList[10])

    highScores=open("highScores.txt", "w")
    for score in highScoresList:
        highScores.write(str(score)+"\n")
    highScores.close()

    highNames=open("highNames.txt", "w")
    for name in highNamesList:
        highNames.write(name+"\n")
    highNames.close()

    

def printHighScores():
    highNames=open("highNames.txt", "r")
    highScores=open("highScores.txt", "r")
    highScoresList=[]
    for score in highScores:
        highScoresList.append(score.strip())
    print("The high scores are:")
    counter=0
    for name in highNames:
        print(highScoresList[counter], end=" ")
        print(name)
        counter+=1
    highScores.close()
    highNames.close()


    
#problems
    #will say it's a word if is inside a different word (der because derogatory or ion because dictionary)
#main
lettersAvail=['','','','','','','','','','','','','','','','','','','','','']
choice=Choice()
lettersAvail=NewLetters(lettersAvail, [0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20])
points=0
while True:
    if choice=="1":
        import time
        start=time.time()
        while time.time()-start<60:
            GetLetters(lettersAvail)
            word=input()
            if word.lower() not in open('words_alpha.txt').read():
                print("This is not a word in the dictionary")
                continue
            if len(word) <3:
                print("Invalid Input\nWords Must Be 3 or More Letters")
                continue
            
            isContained=CheckIfLettersInChoice(word.upper(), lettersAvail)
            if isContained: 
                points+=len(word)

        print("You scored" , points)
        EnterHighScores(points)
        printHighScores()
        
        points=0
        choice=Choice()
                
    elif choice=="2":
        try:
            printHighScores()
            
        except FileNotFoundError:
            print("There are no highScores")
        
        
            
        choice=Choice()
        

    elif choice!="3":
        print("Invalid Input\nTry Again")
        choice=Choice()
    
    else:
        break
        
