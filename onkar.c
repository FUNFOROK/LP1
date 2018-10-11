#include<avr/io.h>

void main()
{
DDRC=0b0000000;   //set PORTC as input port
DDRB=0b00011110;  //PB1, PB2, PB3, PB4 as output port
int ls=0, rs=0;   // define & initialize ls, rs integer as 0 to acquire the left sensor status in ls and right sensor status in rs

while(1)          // create infinite loop
{
ls=(PINC&0b0000001);   //acquire only left sensor status connected at PC0
rs=(PINC&0b0001000);   // acquire only right sensor status connected at PC3

if((ls==0b0000000)&(rs==0b0000000)) //check sensor status for both sensor OFF
{
PORTB=0b00000000;  //stop
ls=0;              //set sensor status off
rs=0;              //set sensor status off
}

if((ls == 0b0000001)&(rs == 0b0000000))  //check sensor status for left sensor=ON and right sensor=OFF

{

PORTB=0b00010000;    //turn right
ls=0;                //set sensor status off
rs=0;                //set sensor status off
}

if((ls == 0b0000000)&(rs == 0b0001000))  //check sensor status for left sensor=OFF and right sensor=ON

{

PORTB=0b00000010;   //turn left
ls=0;               //set sensor status off
rs=0;               //set sensor status off
}
if((ls==0b0000001)&(rs==0b0001000)) //check sensor status for both sensor ON
{
PORTB=0b00010010;  //move forward
ls=0;              //set sensor status off
rs=0;              //set sensor status off
}
}
}
