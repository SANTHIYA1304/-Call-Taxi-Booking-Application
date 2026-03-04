 Taxi booking application where customers can book taxis available at certain points in a linear
route.

Problem Assumptions:
• Taxi Count: 4 taxis (scalable to any number)

• Points on Route: A, B, C, D, E, F — each 15 km apart

• Travel Time Between Points: 60 minutes

• Charges: Minimum Rs.100 for the first 5 km; Rs.10 per km thereafter

• Initial Position: All taxis stationed at A

Booking Rules:
• A free taxi at the pickup point is allocated first.

• If no free taxi is available at pickup, the nearest free taxi is allocated.

• If two taxis are free at the same point, the one with lower earnings is allocated.

• Taxis only charge from the pickup point to the drop point.

• If no taxi is available, the booking is rejected


<img width="764" height="532" alt="Screenshot 2026-03-04 205134" src="https://github.com/user-attachments/assets/4961a607-e551-4972-a0fb-c48bf11c1622" />
