#include<stdio.h>
#define n 5
int main()
{
    int bt[n],at[n],wt[n],tat[n];
    int st[n];
    int tq;
    int executed[n];
    int timer=0;
    int temp=0;
    int i;
    int sq=0;
    printf("\nEnter the burst time in sequence\n ");
    for(i=0;i<n;i++)
    {
        scanf("%d",&bt[i]);
    }
    printf("\nEnter the arrival time in sequence(wrt 0 as starting time)\n ");
    for(i=0;i<n;i++)
    {
        scanf("%d",&at[i]);
    }
    for(i=0;i<n;i++)
        st[i]=bt[i];
    for(i=0;i<n;i++)
    {
        wt[i]=0;
        tat[i]=0;
        executed[i]=0;
    }
    printf("\n Enter the time quantum - ");
    scanf("%d",&tq);
    int count=0;
    while(1)
    {
        for(i=0;count<n;timer++)
        {
            if(at[i]<=timer)//if process ahs arrived before the timer
            {
                temp=tq;
                if(st[i]==0)
                {
                    i=(i+1)%n;
                    count++;
                    continue;
                }
                if(st[i]>tq)
                {
                    st[i]-=tq;
                }
                else if(st[i]>0)
                {
                    temp=st[i];
                    st[i]=0;
                }
                sq+=temp;
                tat[i]=sq;
                i=(i+1)%n;
            }
            else
            {
                i=(i+1)%n;
                continue;
            }
        }
        if(n==count)
            break;
    }
    for(i=0;i<n;i++)
    {
        wt[i]=tat[i]-bt[i]-at[i] ;
    }
    printf("\nPROCESSNO BURSTTIME ARRIVALTIME WAITTIME Turnaround time\n");
    for(i=0;i<n;i++)
        printf("p%d\t%d\t%d\t\t%d\t\t%d\n",i+1,bt[i],at[i],wt[i],tat[i]);
    return 0;
}
