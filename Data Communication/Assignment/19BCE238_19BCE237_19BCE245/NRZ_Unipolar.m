%Implementation of NRZ Unipolar in MATLAB

n=[0 1 1 0 0 1 1 0 1 0]; %our input vector with each bit as 0/1

%Unipolar Mapping
for m=1:length(n) %runs the loop from first bit to last bit
    if n(m)==0 %if the current bit is 0 then it sets value of that bit in nn(m) as 0
        nn(m)=0;
    else
        nn(m)=1; %if the current bit is 1 then it sets value of that bit in nn(m) as 1
    end
end

i=1; %variable to keep a track on index of input data bits

time=0:.01:length(n); %generates a regularly spaced vector time with intervals of 0.01 from values 0 to length of n

for j=1:length(time) %variable to keep a track on index of time vector
    if time(j)<=i
        y(j)=nn(i); %if the value at current index of time vector is less than or equal to the current index of input data bit then,
                    %it assigns value present at current index of input
                    %data bit to vector y (Here vector y stores the values
                    %corresponding to each value of time vector)
    else
        y(j)=nn(i); %if the value at current index of time vector is greater than the current index of input data bit then,
                    %it assigns value present at current index of input
        i=i+1;      %then it increments the index of input data vector
    end
end

plot(time,y); %plots graph between time axis and y axis
title('NRZ Unipolar'); %sets the title of the plot
xlabel('Time'); %sets the label of X axis
ylabel('Amplitude'); %sets the label of Y axis
axis([0 length(n) -2 2]) %defines the range of x axis and y axis. Here x axis is set from 0 to length of n and Y axis is set from -2 to 2