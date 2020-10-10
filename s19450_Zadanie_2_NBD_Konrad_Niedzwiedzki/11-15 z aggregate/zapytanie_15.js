var results = db.people.aggregate([{
        $match: {
            sex: "Female",
            nationality: "Poland"
        }}, {
            $unwind: "$credit"
        }, {
            $group: {
            _id: "$credit.currency",
            "summed_balance": { "$sum": "$credit.balance" },
            "avg_balance": { "$avg": "$credit.balance" }
        }
    }])
.toArray();
printjson(results)