var results = db.people.aggregate({
        $unwind: "$credit"
    }, {
        $group: {
            _id: "$credit.currency",
            "summed_balance": { "$sum": "$credit.balance" }
        }
})
.toArray();
printjson(results)