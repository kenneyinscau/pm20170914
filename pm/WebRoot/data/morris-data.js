$(function() {
	var finishCount=${finishCount};
	var nonfinishCount=${nonfinishCount};
    Morris.Donut({
        element: 'morris-donut-chart',
        data: [{
            label: "finish",
            value: finishCount
        }, {
            label: "nonfinish",
            value: nonfinishCount
        }],
        resize: true
    });
  
});
