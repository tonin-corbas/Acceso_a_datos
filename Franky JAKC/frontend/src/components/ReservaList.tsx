import React from 'react';

const ReservaList: React.FC = () => {
  return (
    <table className="table table-bordered">
      <thead>
        <tr>
          <th>ID</th>
          <th>Check-In</th>
          <th>Check-Out</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>1</td>
          <td>2025-04-01</td>
          <td>2025-04-03</td>
        </tr>
      </tbody>
    </table>
  );
};

export default ReservaList;
