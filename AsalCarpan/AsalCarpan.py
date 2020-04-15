a = int(input("girdi: "))
print (a)

def AsalCarpan(a):
    n=1
    bol=[]
    while a%2==0:
        a=a/2
        bol.append(2)
    while n==1:
        koka=int(a**(1/2))+2
        b=0
        for d in range(3,koka,2):
            if a%d==0:
                a=a/d
                bol.append(d)
                b=1
                break
            if b==0 and d==koka-1 or d==koka-2:
                bol.append(int(a))
                a=1
                break
        if a==1:
            break
    return(bol)
    print (bol)
     
cikti = AsalCarpan(a)
print (cikti)
