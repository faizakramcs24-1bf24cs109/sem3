#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};


struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}


void insertEnd(struct Node **head, int data) {
    struct Node *newNode = createNode(data);
    if (*head == NULL) {
        *head = newNode;
        return;
    }
    struct Node *temp = *head;
    while (temp->next != NULL)
        temp = temp->next;
    temp->next = newNode;
}


void display(struct Node *head) {
    if (head == NULL) {
        printf("List empty.\n");
        return;
    }
    struct Node *temp = head;
    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }
    printf("NULL\n");
}


void deletefirst(struct Node **head) {
    if (*head == NULL) {
        printf("List empty.\n");
        return;
    }
    struct Node *temp = *head;
    *head = (*head)->next;
    free(temp);
}


void deleteEnd(struct Node **head) {
    if (*head == NULL) {
        printf("List empty.\n");
        return;
    }
    struct Node *temp = *head;
    if (temp->next == NULL) {
        free(temp);
        *head = NULL;
        return;
    }
    while (temp->next->next != NULL)
        temp = temp->next;
    free(temp->next);
    temp->next = NULL;
}

void deletePosition(struct Node **head, int pos) {
    if (*head == NULL) {
        printf("List empty.\n");
        return;
    }
    if (pos == 1) {
        deleteStart(head);
        return;
    }
    struct Node *temp = *head;
    for (int i = 1; temp != NULL && i < pos - 1; i++)
        temp = temp->next;

    if (temp == NULL || temp->next == NULL) {
        printf("Invalid position.\n");
        return;
    }

    struct Node *toDelete = temp->next;
    temp->next = toDelete->next;
    free(toDelete);
}


void sortList(struct Node *head) {
    if (head == NULL)
        return;

    struct Node *i, *j;
    int temp;
    for (i = head; i->next != NULL; i = i->next) {
        for (j = i->next; j != NULL; j = j->next) {
            if (i->data > j->data) {
                temp = i->data;
                i->data = j->data;
                j->data = temp;
            }
        }
    }
}


void reverseList(struct Node **head) {
    struct Node *prev = NULL, *curr = *head, *next = NULL;
    while (curr != NULL) {
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }
    *head = prev;
}


struct Node* concatenate(struct Node *head1, struct Node *head2) {
    if (head1 == NULL) return head2;
    if (head2 == NULL) return head1;

    struct Node *temp = head1;
    while (temp->next != NULL)
        temp = temp->next;
    temp->next = head2;

    return head1;
}

// Main function
int main() {
    struct Node *list1 = NULL, *list2 = NULL;
    int choice, data, pos;

    while (1) {
        printf("\n--- SINGLY LINKED LIST MENU ---\n");
        printf("1. Insert\n");
        printf("2. Display\n");
        printf("3. Delete from start\n");
        printf("4. Delete from end\n");
        printf("5. Delete from any position\n");
        printf("6. Sort list\n");
        printf("7. Reverse list\n");
        printf("8. Concatenate two lists\n");
        printf("9. Exit\n");
        printf("Enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
        case 1:
            printf("Enter data to insert: ");
            scanf("%d", &data);
            insertEnd(&list1, data);
            break;
        case 2:
            display(list1);
            break;
        case 3:
            deletefirst(&list1);
            break;
        case 4:
            deleteEnd(&list1);
            break;
        case 5:
            printf("Enter position: ");
            scanf("%d", &pos);
            deletePosition(&list1, pos);
            break;
        case 6:
            sortList(list1);
            printf("List sorted successfully.\n");
            break;
        case 7:
            reverseList(&list1);
            printf("List reversed successfully.\n");
            break;
        case 8:
            printf("Creating second list for concatenation...\n");
            insertEnd(&list2, 100);
            insertEnd(&list2, 200);
            insertEnd(&list2, 300);
            list1 = concatenate(list1, list2);
            printf("Lists concatenated successfully.\n");
            break;
        case 9:
            exit(0);
        default:
            printf("Invalid choice.\n");
        }
    }

    return 0;
}
