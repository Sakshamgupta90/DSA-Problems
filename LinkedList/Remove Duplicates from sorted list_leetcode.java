//method: we will use pointers. what we will do is that we will iterate through our list and keep two pointers one prev at head and next curr at head.next. We will keep moving our curr ptr until it will not reach till the null value. And if in between we will get any duplicates then we will create thord ptr forw whoch will be at curr.next position. So in that case first we will disconnect the list between curr and forw by curr.next = null. so this will break the list. and then we will place our curr at the position of forw. and then we will link our prev ptr with curr. this will help us to remove the duplicates in the list.
