        int count = 0, left = 0, right = 0;
        int curr_sum = nums[0];
        while (right < n) {
            while(left <= right && curr_sum > sum) {
                curr_sum -= nums[left];
                left++;
            }
            if (curr_sum == sum) {
                count++;
            }

            right++;
            if(right < n) {
                curr_sum += nums[right];
            }
        }   
            
        return count;