#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};


struct Node* createNode(int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    if (newNode == NULL) {
        printf("Memory allocation failed!\n");
        exit(1);
    }
    newNode->data = value;
    newNode->next = NULL;
    return newNode;
}

void insertAtEnd(struct Node** head, int value) {
    struct Node* newNode = createNode(value);

    if (*head == NULL) {
        *head = newNode;
        return;
    }

    struct Node* temp = *head;
    while (temp->next != NULL) {
        temp = temp->next;
    }
    temp->next = newNode;
}
void insertfront(struct Node** head, int num){
    
    struct Node * newnode=createNode(num);
    if (*head == NULL) {
        *head = newnode;
        return;
    }
    newnode->next=*head;
    *head=newnode;
   }

void displayList(struct Node* head) {
    struct Node* temp = head;
    printf("Linked List: ");
    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }
    printf("NULL\n");
}
void insafter(struct Node** head, int after_which_val, int val){
    struct Node* newnode= createNode(val);
    struct Node* temp= *head;

    while(temp->data!=after_which_val){
        temp=temp->next;
    }
    struct Node* t2;
    t2=temp->next;
    temp->next=newnode;
    newnode->next=t2;
}

void freeList(struct Node* head) {
    struct Node* temp;
    while (head != NULL) {
        temp = head;
        head = head->next;
        free(temp);
    }
}

int main() {
    struct Node* head11 = NULL;
    int choice, value;
    int a=0;

    while (1) {
        printf("\nMenu:\n");
        printf("1. Insert at end\n");
        printf("2. insert in front\n");
        printf("3. display\n");
        printf("4. insert after\n");
        printf("5. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                printf("Enter value to insert: ");
                scanf("%d", &value);
                insertAtEnd(&head11, value);
                break;
            case 2:
            printf("Enter value to insert: ");
                scanf("%d", &value);
                insertfront(&head11,value);
                break;

               
            case 3:
             displayList(head11);
                break;
            
            case 4:
                
                printf("Enter value after which u wanna insert: ");
                scanf("%d", &value);
                printf("Enter value to insert: ");
                scanf("%d", &a);
                insafter(&head11,value,a);
                break;
            case 5:
            freeList(head11);
                 printf("Exiting program.\n");
                exit(0);
            
               default:
                printf("Invalid choice! Try again.\n");
        }
    }

    return 0;
}