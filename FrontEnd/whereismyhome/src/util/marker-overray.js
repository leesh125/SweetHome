export default function (data) {
  console.log(data)
  return `<div style="background-color: white; padding: 5px; border: 1px solid; border-radius: 5px;" >
      <h6>${data.aptName}</h6>
        ${data.address.sidoName + " " + data.address.gugunName + " " + data.address.dongName }
        ${data.jibun}
        <br />
  </div>`;
}
