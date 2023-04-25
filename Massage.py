#Massage menu
massage_menu = {"full body":250,"upper body":120,"lower body":150,"special deal":0}

#Displaying the menu
def display():
    print("#"*20)
    print("SIT BACK AND RELAX!")
    print("#"*20)
    print("Welcome to the massage simulator where you can choose to take any massage you want")
    print(" MASSAGES")
    for key,value in massage_menu.items():
                print(key,"- $", value)

#Running the program
def main():
    display()
    cost = 0
    while True:
        try:
            #user chooses massage
            massage_choice = input(">> What massage do you want ? : ")
            #logger
        except Exception as e:
            print("No massage for you then :/")
            #Checking which massage is chosen and setting cost accordingly
        else:
            massage_choice.lower()
            if massage_choice not in ["full body","upper body","lower body","special deal"]:
                print("No massage for you :/")
                exit()
            else:
                cost += 1.05 * (massage_menu.get(massage_choice))
        print("Your total will be $",cost)

        #Asking user if they want more
        onceMore = input("Do you want another massage ?:y/n : ")
        onceMore.lower()
        if onceMore[0] not in ['y','n'] or onceMore[0] == 'n':
            print("Ok have a great time :/")
            break
        else:
            print("OK!")

#Invoking main()
main()
        