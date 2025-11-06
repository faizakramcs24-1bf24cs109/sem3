#include <stdio.h>
#define N 6

int Queue[N];
int front=-1; rear=-1;

void enqueue(int value){
    if((front==0&&rear==N-1)||(rear+1)%N==front){
        printf("Queue is full");
    } else{
        if(front==-1){
            front=0;
        }
        rear=(rear+1)%N;
        queue[rear]=value;
        printf("inserted %d",value);
    }
}

void dequeue(){
    if(front==-1){
        print("Queue is empty");
    }else{
        printf("Deleted element;%d",Queue[front]);
        if(front==rear){
            front=rear=-1;
        }else{
            front=(front+1)%N;
        }
        
    }
}

void display(){
    if(front==-1){
        printf("Queue is Empty");
    }else{
        printf("Queue element:");
        int i=front;
        while(1){
            printf("%d",Queue[i]);
            if (i==rear){
                break;
            }
            i=(i+1)%N;
        }
    }
}
int main(){
    int choice,value;
    while(1){
        printf("\n\n---CIRCULA QUEUE");
        printf("\n1.Enqueu\n2.Dequeue\n3.Display\n4.Exit");
        printf("\nEnte your choice");
        scanf("%d",&choice);

        switch(choice){
            case1:
            printf("Enter the value to insert:");
            scanf("%d",&value);
            enqueue(value);
            break;
            case2:
            dequeue(value);
            break;
            case3:
            display();
            break;
            case4:
            return 0;
            default:
            printf("\nInvali choice");

        }
    }
}