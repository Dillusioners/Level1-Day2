#The place where the numbers appearing in the sequence will be stored
memoStore = []

#Simple display method 
def display():
    print("#"*20)
    print("   COLLATZ CHAIN    ")
    print("#"*20)

#Solving collatz chain using recursion
def solve(starting,holder):
    #Stopping recursion if reaching base case. End of chain
    if starting == 1:
        holder.append(starting)
        return 1
    #Work if number is even
    elif starting % 2 == 0:
        holder.append(starting)
        return solve(starting // 2,holder)
    #Work if number is odd
    else:
        holder.append(starting)
        return solve((starting * 3) + 1,holder)
    
#Taking input
def input_taker():
    #logging some errors in!
    try:
        startingNumber = int(input(">> Enter the number : "))
    except ValueError as VE:
        print("Something went wrong :(")
        print(VE)
    else:
        solve(startingNumber,memoStore)
        print("Collatz Sequence is ->\n",memoStore)
    finally:
        print("Program has ended! ")        

#Running the program
def main():
    display()
    print(">> Welcome to the collatz chian printer which will give you the values in the collatz chain of any certain number !")
    input_taker()

main()