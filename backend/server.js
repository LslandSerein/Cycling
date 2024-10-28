const express = require('express');
const cors = require('cors');
const db = require('./database');

const app = express();
const PORT = 3000;

app.use(cors());
app.use(express.json()); // 解析JSON请求体

// 添加跑步记录
app.post('/api/run_records', (req, res) => {
    const { run_time, duration, speed } = req.body;
    db.run(`INSERT INTO run_records (run_time, duration, speed) VALUES (?, ?, ?)`, [run_time, duration, speed], function(err) {
        if (err) {
            return res.status(500).send(err.message);
        }
        res.status(201).json({ id: this.lastID });
    });
});

// 获取所有跑步记录
app.get('/api/run_records', (req, res) => {
    db.all(`SELECT * FROM run_records`, [], (err, rows) => {
        if (err) {
            return res.status(500).send(err.message);
        }
        res.json(rows);
    });
});

// 启动服务器
app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});
