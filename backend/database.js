const sqlite3 = require('sqlite3').verbose();

const db = new sqlite3.Database('./run_records.db', (err) => {
    if (err) {
        console.error(err.message);
    }
    console.log('Connected to the run_records database.');
});

// 创建表
db.serialize(() => {
    db.run(`CREATE TABLE IF NOT EXISTS run_records (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        run_time TEXT,
        duration INTEGER,
        speed REAL
    )`);
});

module.exports = db;
