#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main()
{
    int r,c,i,sum=0;
    double res;
    scanf("%d%d",&r,&c);
    int *p = (int *)malloc(r*c*sizeof(int));
    for(int i=0;i<r;i++)
        for(int j=0;j<c;j++)
            scanf("%d",(p+i)+j);
    for(int i=0;i<r;i++)
    {
        for(int j=0;j<c;j++)
            printf("%d ",*(p+i)+j);
        printf("\n");
    }
    return 0;
}
